public class Model {
@SerializedName("page")
private int page;

@SerializedName("results")
private List<Result> results;

@SerializedName("total_results")
private int total;

@SerializedName("total_pages")
private int totalPages;

//.......getter setter methods

}


public class Result{
@SerializedName("vote_count")
private int voteCount;

@SerializedName("vote_average")
private double voteAverage;

@SerializedName("overview")
private String overView;

//.....other fields
//......getter setter methods
}