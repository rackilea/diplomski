Options specific to weka.classifiers.misc.InputMappedClassifier:

-I
    Ignore case when matching attribute names and nominal values.
-M
    Suppress the output of the mapping report.
-trim
    Trim white space from either end of names before matching.
-L <path to model to load>
    Path to a model to load. If set, this model
    will be used for prediction and any base classifier
    specification will be ignored. Environment variables
    may be used in the path (e.g. ${HOME}/myModel.model)
-W
    Full name of base classifier.
    (default: weka.classifiers.rules.ZeroR)
-output-debug-info
    If set, classifier is run in debug mode and
    may output additional info to the console
-do-not-check-capabilities
    If set, classifier capabilities are not checked before classifier is built
    (use with caution).