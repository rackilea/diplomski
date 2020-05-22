for (int i = 0; i < 3; i++) {
        triangle.moveTo(random.nextInt(400) + 50, random.nextInt(400) + 50);
        triangle.lineTo(random.nextInt(400) + 50, random.nextInt(400) + 50);
        triangle.lineTo(random.nextInt(400) + 50, random.nextInt(400) + 50);
        triangle.closePath();
        area.add(new Area(triangle));
    }