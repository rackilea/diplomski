octave:2> max_dimension = 3;
octave:3> max_filtration_value = 4;
octave:4> num_divisions = 1000;
octave:5> point_cloud = javaMethod( 'getHouseExample', 'edu.stanford.math.plex4.examples.PointCloudExamples')
point_cloud =

<Java object: double[][]>

octave:6> stream = javaMethod( 'createVietorisRipsStream', 'edu.stanford.math.plex4.api.Plex4', point_cloud, max_dimension, max_filtration_value, num_divisions) 
stream =

<Java object: edu.stanford.math.plex4.streams.impl.VietorisRipsStream>

octave:7> persistence = javaMethod( 'getModularSimplicialAlgorithm', 'edu.stanford.math.plex4.api.Plex4', max_dimension, 2)
persistence =

<Java object: edu.stanford.math.plex4.autogen.homology.IntAbsoluteHomology>

octave:8> intervals = persistence.computeIntervals(stream)
intervals =

<Java object: edu.stanford.math.plex4.homology.barcodes.BarcodeCollection>