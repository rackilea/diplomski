Job job = new Job();
job.setTitle("Web developer");
Category catJS = new Category();
catJS.setName("javascript");
Category catCSS = new Category();
catCSS.setName("CSS");
Category catNG = new Category();
catNG.setName("AngualrJS");
Category catHTML = new Category();
catHTML.setName("HTML5");
//persist categories separately
jobservice.persistCategory(catNG);
jobservice.persistCategory(catCSS);
jobservice.persistCategory(catHTML);
jobservice.persistCategory(catJS);
//at this point, we have 4 categories as managed entities
//add the saved categories to a new job instance
job.getCategories().add(catHTML);
job.getCategories().add(catJS);

//save job in DB
jobservice.persistJob(job);
//we do not need to set Job references in Category objects, because Job is the relationship owner - it will correctly update the FKs in join table
assertNotNull("job should be saved", job.getId());
Job fromDb = jobservice.getJob(job.getId());//reload from DB
assertNotNull("job should be stored in DB", fromDb);
assertTrue("job should have 2 categories", fromDb.getCategories().size() == 2);
//great si far so good  

//remove one of the assigned categories from Job(this is where you need that **equals** method in Category )
fromDb.getCategories().remove(catHTML);
assertTrue("job should not have only one category in Memory", fromDb.getCategories().size() ==1);
jobservice.saveJob(fromDb);
//we do not want to delete the *HTML* category from DB, just remove it from the particular job
Job fromDbAfterUpdate = jobservice.getJob(job.getId());
assertTrue("job should not have only one category in BD", fromDbAfterUpdate.getCategories().size() ==1);
List<Category> allCategories = jobservice.getAllCategories();
assertTrue("there should still be 4 categories in DB", allCategories.size() == 4);


//now lets test the Merge cascade
Category unsavedCategory = new Category();
unsavedCategory.setName("jquery");
fromDbAfterUpdate.getCategories().add(unsavedCategory );
//we have added an unsaved category to an  existing job. As Job has cascade merge on it categories, the *unsavedCategory* will be saved and then linked to job via job_category join table
jobservice.saveJob(fromDbAfterUpdate);
fromDbAfterUpdate = jobservice.getJob(fromDbAfterUpdate.getId());
assertTrue("job should now have 2 categories", fromDbAfterUpdate.getCategories().size() ==2);


// one more test, add and remove at the same time
fromDbAfterUpdate.getCategories().remove(catJS);
fromDbAfterUpdate.getCategories().add(catHTML);
fromDbAfterUpdate.getCategories().add(catCSS);
jobservice.saveJob(fromDbAfterUpdate);
fromDbAfterUpdate = jobservice.getJob(fromDbAfterUpdate.getId());
assertTrue("job should now have 3 categories", fromDbAfterUpdate.getCategories().size() ==3);
allCategories = jobservice.getAllCategories();
assertTrue("there should be 5 categories in DB", allCategories.size() == 5);