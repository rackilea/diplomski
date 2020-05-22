public long sizePath(String a_path) throws IOException{     

    long l_used = 0;
    FileStatus[] files = m_fileSystem.listStatus(new Path(a_path));
    for (FileStatus file : files)
        l_used += file.getLen();

    return l_used;

}