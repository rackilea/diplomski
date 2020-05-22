Color[] colors = new Color[] { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW };

Color randomColor = colors[(int)( Math.random() * 4)];

// or try this one
//Color randomColor = colors[new Random().nextInt(4)];