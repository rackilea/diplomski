inlineEditing: {
    ajaxSaveOptions: { contentType: "application/json" },
    serializeSaveData: function (postData) {
        return JSON.stringify(postData);
    }
}