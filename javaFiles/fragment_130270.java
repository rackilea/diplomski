@Transactional
    public UserResponse createCategory(SubmitReviewRequest createCategoryRequest) throws SQLException, ClassNotFoundException, IOException {
        Category category = new Category();
        // read parent
        Category parentCategory  = adminServiceDao.find(Integer.parseInt(createCategoryRequest.getMainCategory()));
        UserResponse userResponse = new UserResponse();
        if (createCategoryRequest != null) {
            category.setCategoryName(createCategoryRequest.getSubCategory());
            // category.setParenCategoryId(Integer.parseInt(createCategoryRequest.getMainCategory()));
            //set the child relationship.
            category.setParentCategory(parentCategory);
            int id = adminServiceDao.saveCategory(parentCategory);
            userResponse.setCode(WeekenterConstants.SUCCESS_CODE);
            userResponse.setMessage("Success");
            userResponse.setId(id);
        }

        return userResponse;
    }