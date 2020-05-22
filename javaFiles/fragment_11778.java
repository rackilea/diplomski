String result[] = new String [lines.size()*3];
    int j=0;
    for (int i=0; i<lines.size(); i++)
    {
        System.arraycopy(lines.get(0).split("\\s*:\\s*"), 0, result, j, 3);
        j+=3;
    }
    System.out.println(Arrays.toString(result));