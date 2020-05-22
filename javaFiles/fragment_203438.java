$.ajax({
    url: 'JsonProcessor.do',
    type: 'post',
    dataType: 'json',
    data: {
            loadProds: 1,
            test: StateObject
          },
      ...