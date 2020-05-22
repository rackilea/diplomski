$('#fileDataCollectJqGrid').jqGrid('setGridParam', {
                postData: {
                    collectId: "${collectId}",
                    baseDate: $('#dateInput').val(),
                    diseaseCode: $('#diseaseSelect').val(),
                    fileName: $('#fileNameInput').val(),
                    stateCode: $('#collectionStatus').val()
                },
            }).trigger('reloadGrid');