private void analyzeImage(Uri selectedImage) {
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
            Mat imageMat = new Mat();
            Utils.bitmapToMat(bitmap, imageMat);
            Mat rgbMat = imageMat.clone();     
            Imgproc.cvtColor(imageMat, imageMat, Imgproc.COLOR_BGR2GRAY);
            imageMat = find2BlackLines(imageMat, rgbMat);          
            Utils.matToBitmap(imageMat, bitmap);
            imageView.setImageBitmap(bitmap);
            imageMat.release();
            rgbMat.release();
            saveToInternalStorage(bitmap);
        } catch (IOException e) {
        }
    }

private Mat find2BlackLines(Mat imageMat, Mat rgbMat) {
    int lineCount = 0;
    ArrayList<Integer> darkLines = new ArrayList<>();
    int line_start = imageMat.rows();
    int line_end = 0;
    double maxLinecount = imageMat.cols() * 0.4;
    double midCol = imageMat.cols()/2;
    int thresholdCol = (int) midCol/2;
    int startingRowCount = getStartingRowCount(imageMat.rows());
    boolean line_flag = false;
    Timber.d("imageMat.rows() >"+imageMat.rows());
    Timber.d("imageMat.cols() >"+imageMat.cols());
    Timber.d("maxLinecount >"+maxLinecount);
    for (int r = startingRowCount; r >= imageMat.rows()/2; r--) {
            lineCount = 0;
            for (int c = 0; c <= midCol; c++) {
               // if(c >thresholdCol && checkBreakCondition(lineCount, thresholdCol)){
                   // break;
               // }
                if(imageMat.get(r,c)==null){
                    continue;
                }
                if (imageMat.get(r, c)[0] == 0 || imageMat.get(r,c)[0] <= 120)
                    lineCount++;
            }
            Timber.d("lineCount >"+lineCount);
            if (lineCount >= maxLinecount) {
                line_flag = true;
                if (line_start == imageMat.rows()) {
                    line_start = r;
                } else {
                    line_end = r;
                }
            } else if (line_flag) {
                darkLines.add(line_start);
                darkLines.add(line_end);

                line_start = imageMat.rows();
                line_end = 0;
                line_flag = false;
            }
            if (darkLines.size() == 2)
                break;
            r=r-20;
        }

        Timber.d("size of darkKines array >> "+darkLines.size());
        if (darkLines.isEmpty() ) {//|| darkLines.size()<3
            return imageMat;
        }
        Timber.d(darkLines.get(0) +" <> "+darkLines.get(1));
//        Timber.d(darkLines.get(2) +" <> "+darkLines.get(3));

        //BBox for the dark lines
        for (int i = 0; i < 1; i++) {
            int index_start_row = darkLines.get(i * 2);
            int index_end_row = darkLines.get(i * 2 + 1);
            Imgproc.rectangle(rgbMat, new Point(0, index_start_row), new Point(imageMat.cols(), index_end_row), new Scalar(255, 0, 0, 255), 10);
        }
        return rgbMat;
    }