//
// C++: VideoCapture::VideoCapture(const string& filename)
//

// javadoc: VideoCapture::VideoCapture(String filename)
public VideoCapture(String filename)
{
    nativeObj = n_VideoCapture(filename);

    return;
}