final float radius = 230f;
if(System.currentTimeMillis() > lastUpdated + 1000){
    lastColor = random.nextInt(2) == 1 ? Color.RED : Color.GREEN;
    lastUpdated = System.currentTimeMillis();
}
paint.setColor(lastColor);
canvas.drawCircle(random.nextInt(canvas.getWidth()-radius/2) + radius/2f, random.nextInt(canvas.getHeight()-radius/2) + radius/2f, radius, paint);