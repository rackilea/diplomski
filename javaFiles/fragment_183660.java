package com.nonprofit.nonprofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WoWDetails {

    @SerializedName("battlegroup")
    @Expose
    private String battlegroup;
    @SerializedName("class")
    @Expose
    private Integer _class;
    @SerializedName("race")
    @Expose
    private Integer race;
    @SerializedName("gender")
    @Expose
    private Integer gender;

    public String getBattlegroup() {
        return battlegroup;
    }

    public void setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
    }

    public Integer getClass_() {
        return _class;
    }

    public void setClass_(Integer _class) {
        this._class = _class;
    }

    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

}