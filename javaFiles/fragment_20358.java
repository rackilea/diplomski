@for(i <- currentPage.indices) {
           @for(element <- currentPage.get(i)) {
                <tr>
                    <td>@element.ID</td>
                    <td>@element.EmployeeID</td>
                    <td>@element.RoleID</td>
                    .
                    .
                    .
                </tr>
            }
            }