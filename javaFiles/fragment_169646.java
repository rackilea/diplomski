public static void main(String[] args)  {
   String[] movies = {"Amour", "*Argo", "Beasts of the Southern Wild", "Django Unchained", "Les Misérables", "Life of Pi", "Lincoln", "Silver Linings Playbook", "Zero Dark Thirty"};
    Stack oscarStack = new Stack();

    for(String movie : movies) {
        oscarStack.push(movie);
    }
}