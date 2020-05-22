public static void main(String[] args) {
        Ellipse ellipse = new Ellipse(10,20);
        Rectangle rect1 = new Rectangle(40,20);
        Rectangle rect2 = new Rectangle(40,20);
        Circle circle = new Circle(5);
        String name = "Horse";

        WiLi_Horse horse1 = new WiLi_Horse(ellipse,rect1,rect2,circle,name);
        WiLi_Horse horse2 = new WiLi_Horse(ellipse,rect1,rect2,circle,name);
        WiLi_Horse horse3 = new WiLi_Horse(ellipse,rect1,rect2,circle,name);
        WiLi_Horse horse4 = new WiLi_Horse(ellipse,rect1,rect2,circle,name);

        List<WiLi_Horse> horseList = new ArrayList<>();
        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);
        horseList.add(horse4);
        System.out.println(horseList);
    }