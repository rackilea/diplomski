@import util.Paginator

@(paginatedList: Paginator[Item])(implicit msg: play.api.i18n.MessagesProvider)

@main(msg.messages("label.list_of_items")) {
  <h1>@msg.messages("label.paginated_list")</h1>

  @* populate your list here *@

  @* and this is your paginator *@
  <div class="pagination">
    @paginatedList.prevPage.map { page =>
      <a href="@link(page)">@msg.messages("label.previous")<a>
    }.get
    @for(pageNumber <- 1 to paginatedList.numberOfPages.toInt) {
      <a href="@routes.Controller.list(pageNumber - 1)">@pageNumber</a>
    }
    @paginatedList.nextPage.map { page =>
      <a href="@link(page)">@msg.messages("label.next")</a>
    }.get
  </div>
}