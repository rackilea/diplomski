public void printGPAs(Node node, double gpa_cutoff) {
    if (node == null) {
        return;
    } 

    if (node.gpa >= gpa_cutoff) {
        System.out.println(node.gpa);
    }

    printGPAs(node.left);
    printGPAs(node.right);
}