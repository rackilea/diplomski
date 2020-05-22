JNIEXPORT int JNICALL Java_com_example_jnitest_MainActivity_compressImage(JNIEnv *pEnv, jobject this, jobject inputByteBuffer, jobject outputByteBuffer)
{
    jbyte* pInBuf = (jbyte*)(*pEnv)->GetDirectBufferAddress(pEnv, inputByteBuffer);
    jbyte* pOutBuf = (jbyte*)(*pEnv)->GetDirectBufferAddress(pEnv, outputByteBuffer);

    int lenOutImage = 0; char *pOutputImage;
    pOutputImage = CompressImage((char *)pInBuf,&lenOutImage);

    // copy to byte buffer
    memcpy((char)pOutBuf, pOutputImage, lenOutImage);        
    free(pOutputImage); // free pOutputImage?

    return lenOutImage;
}