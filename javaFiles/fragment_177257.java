%typemap(jstype) cv::Mat& "org.opencv.core.Mat"
    %typemap(javain) cv::Mat& "$javainput.getNativeObjAddr()"
    %typemap(jtype) cv::Mat& "long"
    %typemap(jni) cv::Mat& "jlong"

    %typemap(in) cv::Mat& {
            $1 = *(cv::Mat **)&$input;
    }

    %typemap(jstype) cv::Size& "org.opencv.core.Size"
    %typemap(javain) cv::Size& "$javainput"
    %typemap(jtype) cv::Size& "org.opencv.core.Size"
    %typemap(jni) cv::Size& "jobject"

    %typemap(in) cv::Size& {
            jclass sizeClass = JCALL1(GetObjectClass, jenv, $input);
            jfieldID widthFieldId = JCALL3(GetFieldID, jenv, sizeClass, "width", "D");
            jfieldID heightFieldId = JCALL3(GetFieldID, jenv, sizeClass, "height", "D");
            double width = JCALL2(GetDoubleField, jenv, $input, widthFieldId);
            double height = JCALL2(GetDoubleField, jenv, $input, heightFieldId);
            $1 = new cv::Size((int)width, (int)height);
    }

    %typemap(freearg) cv::Size& {
            delete $1;
    }