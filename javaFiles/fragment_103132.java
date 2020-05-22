# in org request
a_id = genereate_a_random_id() 
logging.info(a_id) # the id will be included 

taskqueue.add(url='/path_to_task', params={'id': a_id})


# in task request
a_id = self.request.get('id')
logging.info(a_id)