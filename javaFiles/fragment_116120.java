.state('book.delete-sel', { // Previous: 'books.delete-sel'
        parent: 'book',
        url: '/delete-sel', // Previous: '/delete'
        data: {
            authorities: ['ROLE_USER']
        },
        params: {
            selectedItems: null
        },
        onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
            $uibModal.open({
                templateUrl: 'app/entities/book/book-delete-sel-dialog.html', // The book-delete-sel-dialog.html didn't exist before
                /*controller: 'BookDeleteController',*/
                controller: 'BookDeleteSelController',
                controllerAs: 'vm',
                size: 'md'
            }).result.then(function() {
                    $state.go('book', null, { reload: true }); // Previous: 'books'
                }, function() {
                    $state.go('^');
                });
        }]
    })