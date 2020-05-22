//Load features from disk
    final List<MemoryLocalFeatureList<FloatKeypoint>> data = new ArrayList<MemoryLocalFeatureList<FloatKeypoint>>();
    final List<FloatKeypoint> allKeys = new ArrayList<FloatKeypoint>();

    for (int i = 0; i < 100; i++) {
        final MemoryLocalFeatureList<FloatKeypoint> tmp = FloatKeypoint.convert(MemoryLocalFeatureList.read(
                new File(String.format("/Users/jsh2/Data/ukbench/sift/ukbench%05d.jpg", i)), Keypoint.class));
        data.add(tmp);
        allKeys.addAll(tmp);
    }

    //randomise their order
    Collections.shuffle(allKeys);

    //sample 1000 of them to learn the PCA basis with 64 dims
    final double[][] sample128 = new double[1000][];
    for (int i = 0; i < sample128.length; i++) {
        sample128[i] = ArrayUtils.convertToDouble(allKeys.get(i).vector);
    }

    System.out.println("Performing PCA " + sample128.length);
    final ThinSvdPrincipalComponentAnalysis pca = new ThinSvdPrincipalComponentAnalysis(64);
    pca.learnBasis(sample128);

    //project the 1000 training features by the basis (for computing the GMM)
    final double[][] sample64 = pca.project(new Matrix(sample128)).getArray();

    //project all the features by the basis, reducing their dimensionality
    System.out.println("Projecting features");
    for (final MemoryLocalFeatureList<FloatKeypoint> kpl : data) {
        for (final FloatKeypoint kp : kpl) {
            kp.vector = ArrayUtils.convertToFloat(pca.project(ArrayUtils.convertToDouble(kp.vector)));
        }
    }

    //Learn the GMM with 128 components
    System.out.println("Learning GMM " + sample64.length);
    final GaussianMixtureModelEM gmmem = new GaussianMixtureModelEM(128, CovarianceType.Diagonal);
    final MixtureOfGaussians gmm = gmmem.estimate(sample64);

    //build the fisher vector representations
    final FisherVector<float[]> fisher = new FisherVector<float[]>(gmm, true, true);

    int i = 0;
    final double[][] fvs = new double[100][];
    for (final MemoryLocalFeatureList<FloatKeypoint> kpl : data) {
        fvs[i++] = fisher.aggregate(kpl).asDoubleVector();
    }