db.col.update(
    {"projectsList.projectNumber": 1}, 
    {$set: {
      "projectsList.$.projectUrl": "http",
      "projectsList.$.projectProposal": "ocr"
    }})