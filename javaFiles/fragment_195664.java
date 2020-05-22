<form ...>
...
  <div th:each="item, iter: ${viewModel.map}">

    <div class="input-group control-group mt-1">
      <input th:field="${viewModel.map[__${iter.index}__].key}"
        th:errorClass="is-invalid"
        class="form-control">
      <input th:field="${viewModel.map[__${iter.index}__].value}"
        th:errorClass="is-invalid"
        class="form-control">
    </div>

    <div class="row invalid-feedback">
      <div class="col-6"
        th:errors="${viewModel.map[__${iter.index}__].key}"></div>
      <div class="col-6"
        th:classappend="${#fields.hasErrors('${viewModel.map[__${iter.index}__].key}') ? '' : 'offset-sm-6'}"
        th:errors="${viewModel.map[__${iter.index}__].value}"></div>
    </div>
  </div>
...
</form>