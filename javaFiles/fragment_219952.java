Pagination pagination = new Pagination();

         pagination.setNumber(1);
         pagination.setEntriesPerPage(200);
         pagination.setTotal(3);

         Categories categories = new Categories(); 
         categories.setPagination(pagination);

         Category category = new Category();
         category.setName("Sunglasses");
         category.setTaskid("79720");

         List<Category> categoryList = new ArrayList<Category>();

         Posting posting = new Posting(); 
         posting.setCategories(categoryList);

         List<ParentCategory> parentCategoryList = new ArrayList<ParentCategory>();
         List<ParentCategory> parentCategoryList2 = new ArrayList<ParentCategory>();

         ParentCategory  parentCategory1 = new ParentCategory(); 
         parentCategory1.setName("Sunglasses & Fashion Eyewear");
         parentCategory1.setTaskid("394");

         ParentCategory  parentCategory2 = new ParentCategory(); 
         parentCategory2.setName("Men's Accessories");
         parentCategory2.setTaskid("2340");

         ParentCategory  parentCategory3 = new ParentCategory(); 
         parentCategory3.setName("Clothing, Shoes & Accessories");
         parentCategory3.setTaskid("10987");

         parentCategoryList.add(parentCategory2); 
         parentCategoryList2.add(parentCategory3);
          parentCategory2.setParentCategory(parentCategoryList2);
         parentCategory1.setParentCategory(parentCategoryList);
         category.setParentCategory(parentCategory1);

          Gson gson = new Gson();
            System.out.println(gson.toJson(category));