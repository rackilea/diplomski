// First we need to validate the new issue being created

IssueInputParameters issueInputParameters = issueService.newIssueInputParameters();
// We're only going to set the summary and description. The rest are hard-coded to
// simplify this tutorial.
issueInputParameters.setSummary(req.getParameter("summary"));
issueInputParameters.setDescription(req.getParameter("description"));
// We need to set the assignee, reporter, project, and issueType...
// For assignee and reporter, we'll just use the currentUser
issueInputParameters.setAssigneeId(user.getName());
issueInputParameters.setReporterId(user.getName());
// We hard-code the project name to be the project with the TUTORIAL key
Project project = projectService.getProjectByKey(user, "TUTORIAL").getProject();
issueInputParameters.setProjectId(project.getId());
// We also hard-code the issueType to be a "bug" == 1
issueInputParameters.setIssueTypeId("1");
// Perform the validation
IssueService.CreateValidationResult result = issueService.validateCreate(user, issueInputParameters);

if (result.getErrorCollection().hasAnyErrors()) {
    // If the validation fails, render the list of issues with the error
    // To Do: Error handling code
} else {
    // If the validation passes, redirect the user to the main issue list page
    issueService.create(user, result);
    resp.sendRedirect("issuecrud");
}