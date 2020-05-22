<div class="col-md-6">
                    <label th:text="#{position}">Position</label>
                    <select th:field="*{position}" class="form-control">
                        <option th:each="position : ${allPositions}"
                                th:value="${position.id}"
                                th:text="${position.name}">Wireframe
                        </option>
                    </select>
                </div>