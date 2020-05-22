GeometricObject go=new Rectangle(sx,sy,ex,ey,colorPicker.getValue());

        if(go instanceof Lines)
            ((Lines)go).draw(transgc);
        else if(go instanceof Eclipse)
            ((Eclipse)go).draw(transgc);
        else if(go instanceof Rectangle)
            ((Rectangle)go).draw(transgc);