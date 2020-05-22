@defining(personForm("categories").indexes.map { i => personForm("categories")("[" + i + "]").value }) { values =>
    @Category.find.all().map { category =>
        <input type="checkbox"
        name="categories[]"
        value="@category.id"
    @if(values.contains(Some(category.id.toString()))) { checked } /> @category.description <br />
    }
}