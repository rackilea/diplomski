package com.ex.mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AggregateFactoryResult {
    String date;
    String country;
    String operator;
    String server_ip;

    ArrayList<Details> details;

    public AggregateFactoryResult(String date, String country, String operator, String server_ip, ArrayList<Details> details){
        super();
        this.country = country;
        this.operator = operator;
        this.server_ip = server_ip;
        this.details = details;
    }

    public AggregateFactoryResult(){
        super();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getServer_ip() {
        return server_ip;
    }

    public void setServer_ip(String server_ip) {
        this.server_ip = server_ip;
    }

    public ArrayList<Details> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Details> details) {
        this.details = details;
    }



}

class Details{
    String type;
    String datetime;
    ArrayList<Module> module;

    public Details(String type, String datetime){
        super();
        this.type = type;
        this.datetime = datetime;
        this.module = new ArrayList<Module>();
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDatetime() {
        return datetime;
    }
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
    public ArrayList<Module> getModule() {
        return module;
    }
    public void setModule(ArrayList<Module> module) {
        this.module = module;
    }

}

class Module{
    ArrayList<ModuleDetail> moduleDetail;

    public Module(ArrayList<ModuleDetail> moduleDetail){
        super();
        this.moduleDetail =  moduleDetail;
    }

    public ArrayList<ModuleDetail> getModuleDetail() {
        return moduleDetail;
    }

    public void setModuleDetail(ArrayList<ModuleDetail> moduleDetail) {
        this.moduleDetail = moduleDetail;
    }

}

class ModuleDetail{
    String module_name;
    String live;

    public ModuleDetail(String module_name, String live){
        super();
        this.module_name = module_name;
        this.live = live;
    }
    public String getModule_name() {
        return module_name;
    }
    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }
    public String getLive() {
        return live;
    }
    public void setLive(String live) {
        this.live = live;
    }


}