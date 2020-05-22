public static void main(String args[])
{
    Animal list = new Animal();

    list.add("Snake", "python,Cobra");
    list.add("Dog", "poodle,Retriever");
    list.add("Cat", "siberian");
    System.out.println(list);
    System.out.println(list.get("Dog"));//shows poodle,Retriever

}