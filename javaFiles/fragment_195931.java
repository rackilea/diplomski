public static List<Session> filter(List<Session> in) {
    List<Session> result = new ArrayList<>();

    for(Session current : in) {
        for(Session other : in) {
            if(current != other && current.isOverlapped(other)) {
                result.add(current);
                break;
            }
        }
    }

    return result;
}