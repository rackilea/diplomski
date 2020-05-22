jclass java_line_cls = env->FindClass("myLinesClass");

jmethodID java_line_add = env->GetMethodID(java_line_cls, "addPoint", "(II)V");  
jmethodID java_line_init = env->GetMethodID(java_line_cls, "<init>", "()V");

jobjectArray resLines = (jobjectArray) env->NewObjectArray(lines.size(),     java_line_cls, 0); 

for(int i = 0; i < lines.size(); ++i)
{
    jobject cur_line =  env->NewObject(java_line_cls, java_line_init);
    for(int j = 0; j < lines[i].size(); ++j)
        env->CallVoidMethod(cur_line, java_line_add, 
                                lines[i][j].x,
                                lines[i][j].y);
    env->SetObjectArrayElement(resLines, i, cur_line);
}

return resLines;