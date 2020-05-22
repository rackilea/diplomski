package jsonProcessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHeader {

public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub  
    BufferedReader reader = null;

    try{
        reader = new BufferedReader(new FileReader("C:/JSON/header.json"));
        Gson gson = new GsonBuilder().create();
        HeaderResult results = gson.fromJson(reader, HeaderResult.class);

        if(results != null){
            for(Header h : results.getHeader()){
                String temp =("ID: "+h.getID()+" Name: "+h.getName());
                for(CompanyList cl : h.getCompanyList()){
                    System.out.println(temp+" "+"Company: "+cl.getCompany());
                }
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try{
                    reader.close();
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        }
}
}

package jsonProcessing;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeaderResult {

@SerializedName("Header")
@Expose
private List<Header> header = null;

public List<Header> getHeader() {
return header;
}

public void setHeader(List<Header> header) {
this.header = header;
}
}

package jsonProcessing;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Header {

@SerializedName("ID")
@Expose
private String iD;
@SerializedName("Name")
@Expose
private String name;
@SerializedName("Company List")
@Expose
private List<CompanyList> companyList = null;

public String getID() {
return iD;
}

public void setID(String iD) {
this.iD = iD;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public List<CompanyList> getCompanyList() {
return companyList;
}

public void setCompanyList(List<CompanyList> companyList) {
this.companyList = companyList;
}
}

package jsonProcessing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyList {

@SerializedName("Company")
@Expose
private String company;

public String getCompany() {
return company;
}

public void setCompany(String company) {
this.company = company;
}
}