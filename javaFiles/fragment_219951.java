import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination implements Serializable
{

    public Pagination() {
        super();
        // TODO Auto-generated constructor stub
    }

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("entriesPerPage")
    @Expose
    private Integer entriesPerPage;
    @SerializedName("total")
    @Expose
    private Integer total;
    private final static long serialVersionUID = 5114620434202813556L;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getEntriesPerPage() {
        return entriesPerPage;
    }

    public void setEntriesPerPage(Integer entriesPerPage) {
        this.entriesPerPage = entriesPerPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}



import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categories implements Serializable
{

    public Categories() {
        super();
        // TODO Auto-generated constructor stub
    }

    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("postings")
    @Expose
    private List<Posting> postings = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    private final static long serialVersionUID = 4589512697836725240L;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Posting> getPostings() {
        return postings;
    }

    public void setPostings(List<Posting> postings) {
        this.postings = postings;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}


import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category implements Serializable
{

    public Category() {
        super();
        // TODO Auto-generated constructor stub
    }

    @SerializedName("taskid")
    @Expose
    private String taskid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("parentCategory")
    @Expose
    private ParentCategory parentCategory;
    private final static long serialVersionUID = -2127963072268572959L;

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParentCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ParentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

}


import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Posting implements Serializable
{

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    private final static long serialVersionUID = 8135185675909461065L;

    public List<Category> getCategories() {
        return categories;
    }

    public Posting() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}


import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParentCategory implements Serializable
{

    @SerializedName("taskid")
    @Expose
    private String taskid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("parentCategory")
    @Expose
    private List<ParentCategory>  parentCategory;


    public ParentCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

    private final static long serialVersionUID = -5989749742502713615L;

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParentCategory> getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(List<ParentCategory> parentCategory) {
        this.parentCategory = parentCategory;
    }

}