gg.setComposite(comp);
        Color ec = gg.getColor();

        gg.setColor(Color.darkGray);

        Shape s = gg.getClip();
        if (s != null)
            gg.fill(s);

        gg.setComposite(existing);
        gg.setColor(ec);