// Create test run
var oRunInstance = (QcClient.RunFactory)oTsTest.RunFactory;
var oRun = (QcClient.Run)oRunInstance.AddItem("Performance Test");
oRun.Status = "Passed";
oRun.Post();
oRun.Refresh();

// Create test run steps
var oTest = (QcClient.Test)oTsTest.Test;
var tsDesignStepList = oTest.DesignStepFactory.NewList("");
var oStepFactory = (QcClient.StepFactory)oRun.StepFactory;
foreach (QcClient.DesignStep oDesignStep in tsDesignStepList)
{
  var oStep = (QcClient.Step)oStepFactory.AddItem(oDesignStep.StepName);
  oStep.Status = "Passed";
  oStep.Post();
}