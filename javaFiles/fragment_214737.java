class Foo {
    Foo next;
    void print(HashSet<Foo> visited) {
        System.out.println("this Foo's ID or whatever it is you're printing");
        visited.add(this);
        if(next != null && !visited.contains(next)) {
            next.print(visited);
        }
    }
}