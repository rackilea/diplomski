TextField field = new TextField(writer, new Rectangle(x, y - h, x + w, y), name);
field.BackgroundColor = new BaseColor(bgcolor[0], bgcolor[1], bgcolor[2]);
field.BorderColor = new BaseColor(
    bordercolor[0], bordercolor[1], bordercolor[2]);
field.BorderWidth = border;
field.BorderStyle = PdfBorderDictionary.STYLE_SOLID;
field.Text = text;
writer.AddAnnotation(field.GetTextField());