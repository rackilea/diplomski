package com.mhis.webfactory.taskflow.album;

import com.mhis.portal.backing.main.JSFUtils;

import com.mhis.webfactory.taskflow.album.model.Image;

import java.util.List;

import java.util.Map;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

public class AlbumPrintManagedBean {
    private Image image;

    public AlbumPrintManagedBean() {
        super();
        image = (Image)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("image");
    }

    private String jym="JYM";

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
}