PDRectangle pageSize = page.findMediaBox();
float pageWidth = pageSize.getWidth();
float pageHeight = pageSize.getHeight();
float lineWidth = Math.max(pageWidth, pageHeight) / 1000;
float markerRadius = lineWidth * 10;
float fontSize = Math.min(pageWidth, pageHeight) / 20;
float fontPadding = Math.max(pageWidth, pageHeight) / 100;