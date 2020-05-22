PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
CustomList list = new CustomList();//not sure what your list is called

//iterate over list {
    writer.println(list.get(currentPosition));
}

writer.close();//saves file