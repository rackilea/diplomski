for (int i = 0; i < arrayBoxes.size(); i++){
    context.clearRect(0, 0, 1580, 700);
    context.beginPath();
    context.setStrokeStyle("limegreen");
    context.setLineWidth(2);
    context.strokeRect(arrayBoxes.get(i).xcoordi, arrayBoxes.get(i).ycoordi, arrayBoxes.get(i).boxWidth, arrayBoxes.get(i).boxHeight);
    context.fill();
}