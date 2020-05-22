if (p.data == target) {
    res = res + p.data;
    System.out.println(res);
} else {
    pathToNode(p.leftLink, target, res + p.data);
    pathToNode(p.rightLink, target, res + p.data);
}