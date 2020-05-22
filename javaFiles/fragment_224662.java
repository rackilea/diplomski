public long getUsed(){      

    long l_used = 0;
    FileStatus[] files = m_fileSystem.listStatus(new Path("/"));
    for (FileStatus file : files)
        l_used += file.getLen();

    return l_used;

}