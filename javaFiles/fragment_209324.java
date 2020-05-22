for (GHP ghp : w.getList()) { // Avoid using get(index) without a forloop, as such
    if (ghp instanceof GBox) { // Using the instanceof operator, you can differentiate the 2 class types
        System.out.println("Box: HP: " + ghp.getHP() + "Volume: "
                + ((GBox) ghp).getVolume()); // Cast it to GBox to be able to call getVolume
    }

    if (ghp instanceof GCircle) {
        System.out.println("Circle: HP: " + ghp.getHP() + "Radius: "
                + ((GCircle) ghp).getRadius());// Cast it to GCircle to be able to call getRadius 
    }
}