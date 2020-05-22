// Type : an object to store information to use later
List<Type> res = new ArrayList<Type>();  
for (int i = 0; i < points.lenght(); i++) {
    for (int j = i+1; j < points.length(); j++) {
       double coefficient = CoeffiecientBetweenTwoLine(
                   line(points[i], points[j]), line((0,0), (0,1));
       res.add(new Type(points[i], points[j], coefficient);
    }
}