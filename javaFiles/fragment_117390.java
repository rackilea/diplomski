class Main {
    public static void main(String[] ignored) throws IOException, ClassNotFoundException {
        String filename = "config.data";

        List<Project> projects = new ArrayList<Project>();
        projects.add(new Project());
        projects.add(new Project());
        projects.add(new Project());

        FileOutputStream fos = new FileOutputStream(new File(filename));
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(projects);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        List<Project> projects2 = (List<Project>) ois.readObject();
        ois.close();
        System.out.println("There was " + projects2.size() + " projects saved");
    }

    static class Project implements Serializable {

    }
}