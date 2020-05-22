<div class="result" th:each="result : ${results}">
            <h3><a th:href="${result.fromUser}" th:text="${result.user.name}"></a></h3>

            <p th:text="'@' + ${result.fromUser}"></p>
            <span th:text="${result.text}"></span>
            <div id="retweet">
                    <a href="JavaScript:Void(0);" th:onclick="'doRetweet(\'' + ${result.id} + '\');'" >Retwt</a>

            </div>
        </div>