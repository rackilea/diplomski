select fname from Name
where upper(fname) like :fnameStart or upper(fname) like :fnameMiddle
order by (case when upper(fname) like :fnameStart then 1 else 2 end), fname

query.setParameter("fnameStart", "XX%");
query.setParameter("fnameMiddle", "% XX%");