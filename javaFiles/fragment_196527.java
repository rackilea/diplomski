//...
    bw.flush();
    bw.close();
    for (int i = 0; i < tasks.size(); i++) {
        DueDate dueDate = tasks.get(i);
        System.out.println(i+". "+dueDate.toString());
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
}